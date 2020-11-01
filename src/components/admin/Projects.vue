<template>
  <div class="projects">

    <div v-if="showDialog" class="loading">
      <div>
        <span class="fa fa-spinner fa-spin fa-5x" v-if="loading"></span>
        <span class="fa  fa-exclamation-circle fa-5x failed" v-else-if="error"></span>
        <span class="fa fa-check fa-5x done" v-else></span>
        <button class="btn round" :class="{'btn-success': !error, 'btn-danger': error}" @click="showDialog = false">OK
        </button>
      </div>
    </div>

    <form action="" @submit.prevent="addToFirebase">
      <input type="text" required class="single-input" v-model="project.name" placeholder="Title">
      <input type="text" required class="single-input" v-model="project.title" placeholder="Moto">
      <input type="text" required class="single-input" v-model="project.keywords" placeholder="Keywords">
      <input type="text" required class="single-input" v-model="project.techs" placeholder="Technology">
      <input type="text" class="single-input" v-model="project.links" placeholder="Links">

      <textarea type="text" required class="single-textarea" v-model="project.description"
                placeholder="Description"></textarea>

      <h6>Thumbs of project</h6>
      <div class="dropbox">
        <input type="file" @change="detectFiles($event.target.files)"
               accept="image/*" class="input-file" :disabled="uploadingThumbFile.progress > 1">
        <p v-if="uploadingThumbFile.progress < 1">
          Drag your file here to begin<br> or click to browse
        </p>
        <p v-else>
          <img :src="uploadingThumbFile.downloadUrl"> <br>
          <span v-if="uploadingThumbFile.progress < 99">Uploading: {{ uploadingThumbFile.progress }}</span>
          <button v-else class="btn-sm btn-danger" @click="removeThumbFile(uploadingThumbFile.fileName)"><i
              class="fa fa-remove"></i>
          </button>
        </p>
      </div>
      <h6>Shots of project</h6>
      <div class="dropbox">
        <input type="file" multiple @change="detectMultipleFiles($event.target.files)"
               accept="image/*" class="input-file">
        <p v-if="uploadingShotsFile.length < 1">
          Drag your file(s) here to begin<br> or click to browse
        </p>
        <div v-else>
          <div class="row">
            <div class="col-4" v-for="uploadFile in uploadingShotsFile" :key="uploadFile.fileName">
              <img :src="uploadFile.downloadUrl"> <br>
              <span v-if="uploadFile.progress < 99">Uploading: {{ uploadFile.progress }}</span>
              <button v-else class="btn-sm btn-danger" @click.prevent="removeThumbFile(uploadFile.fileName)"><i
                  class="fa fa-remove"></i>
              </button>
            </div>
          </div>
        </div>
      </div>

      <button class="btn btn-success" type="submit">Add</button>

    </form>
  </div>
</template>

<script>

import {projectCollection, storage} from "@/firebase";

import {v4 as uuidv4} from 'uuid'

export default {
  name: "Projects",
  data() {
    return {
      uploadingThumbFile: {
        progress: 0,
        fileName: '',
        downloadUrl: ''
      },
      file: File,
      uploadTask: '',
      uploadTasks: [],
      uploadingShotsFile: [],
      project: {},
      loading: false,
      error: false,
      showDialog: false
    }
  },
  methods: {
    addToFirebase() {
      this.project.shots = this.uploadingShotsFile.map(file => {
        return file.downloadUrl
      })

      this.project.thumbs = this.uploadingThumbFile.downloadUrl

      this.project.keywords = this.project.keywords.toString().split(',').map(keyword => {
        return keyword.trim()
      })

      this.project.techs = this.project.techs.toString().split(',').map(keyword => {
        return keyword.trim()
      })

      this.project.links = this.project.links ? [JSON.parse(this.project.links)] : []

      this.showDialog = true
      this.loading = true
      this.error = false

      var _this = this
      projectCollection.add(this.project).then(res => {
        console.log(res)
        _this.error = false
        _this.loading = false
        _this.project = {}
      }).catch(err => {
        console.log(err)
        _this.error = true
        _this.loading = false
      })
    },
    detectFiles(fileList) {
      Array.from(Array(fileList.length).keys()).map(x => {
        console.log(fileList[x])
        this.upload(fileList[x])
      })
    },
    detectMultipleFiles(fileList) {
      Array.from(Array(fileList.length).keys()).map(x => {
        console.log(fileList[x])
        // this.upload(fileList[x])

        var _this = this
        let file = fileList[x];
        let fileName = uuidv4() + '.' + file.name.split('.').pop();
        storage.ref('projects/' + fileName)
            .put(file)
            .then(task => {
              task.ref.getDownloadURL().then(downloadUrl => {
                _this.uploadingShotsFile.push({
                  progress: 100,
                  fileName: fileName,
                  downloadUrl: downloadUrl
                })
              })
            })

      })
    },
    upload(file) {
      let fileName = uuidv4() + '.' + file.name.split('.').pop();
      this.uploadingThumbFile.fileName = fileName;
      this.uploadTask = storage.ref('projects/' + fileName).put(file);
    },
    removeThumbFile(file) {
      var _this = this
      // eslint-disable-next-line no-unused-vars
      storage.ref('projects').child(file.fileName).delete().then(res => {
        _this.uploadingThumbFile.progress = 0
        _this.uploadingThumbFile.downloadUrl = ''
        _this.uploadingThumbFile.fileName = ''
      })
    }
  },
  computed: {},
  watch: {
    uploadTask: function () {
      var _this = this
      this.uploadTask.on('state_changed', sp => {
            _this.uploadingThumbFile.progress = Math.floor(sp.bytesTransferred / sp.totalBytes * 100)
          },
          null,
          () => {
            this.uploadTask.snapshot.ref.getDownloadURL().then(downloadURL => {
              _this.uploadingThumbFile.downloadUrl = downloadURL
            })
          })
    }
  }
}
</script>

<style scoped>
input, textarea {
  margin-bottom: 10px;
}

form div {
  margin-bottom: 10px;
}

.dropbox {
  outline: 2px dashed grey; /* the dash box */
  outline-offset: -10px;
  background: lightcyan;
  color: dimgray;
  padding: 10px 10px;
  min-height: 100px; /* minimum height */
  position: relative;
  cursor: pointer;
}

.input-file {
  opacity: 0; /* invisible but it's there! */
  width: 100%;
  height: 200px;
  position: absolute;
  cursor: pointer;
}

.dropbox:hover {
  background: lightblue; /* when mouse over to the drop zone, change color */
}

.dropbox p {
  font-size: 1.2em;
  text-align: center;
  padding: 20px 0;
}

.dropbox img {
  width: 150px;
  height: 150px;
}

.loading {
  z-index: 999999;
  background: rgba(0, 0, 0, 0.2);
  position: fixed;
  right: 0;
  top: 0;
  bottom: 0;
  left: 0;
  padding: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.loading div {
  text-align: center;
  padding: 50px 200px;
  background: #fff;
  color: var(--orange);
  border-radius: 10px;
}

.loading button {
  display: block;
  margin-top: 20px;
}

.failed {
  color: var(--danger);
}

.done {
  color: var(--success);
}
</style>