<template>
  <!--================ Start Messages Us Area =================-->
  <section class="content_section" style="padding-bottom: 0;">
    <div class="container">
      <div class="row justify-content-start">
        <div class="col-12">
          <h6>Messages</h6>
        </div>
        <div class="col-12">

          <table class="table">
            <thead>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
            </thead>

            <tbody>

            <tr v-if="loading">
              <td colspan="4">
                <p class="text-center"><i class="fa fa-spin fa-spinner fa-5x"></i></p>
              </td>
            </tr>

            <tr v-else-if="messages.length < 1">
              <td colspan="4">
                <p class="text-center"><i class="fa fa-trash fa-3x"></i> No message found!</p>
              </td>
            </tr>

            <tr v-for="(doc, index) in messages" :key="index">
              <td>{{ index + 1 }}</td>
              <td>{{ doc.name }}</td>
              <td>{{ doc.email }}</td>
              <td>{{ doc.message }}</td>
            </tr>
            </tbody>
          </table>

        </div>
      </div>
    </div>
  </section>
  <!--================ End About Us Area =================-->
</template>

<script>
import {messageCollection} from "@/firebase";

export default {
  name: "Messages",
  data() {
    return {
      messages: [],
      loading: false
    }
  },
  methods: {
    async getMessages() {
      this.loading = true
      const snapshot = await messageCollection
          .orderBy('created', "desc")
          .limit(20).get()

      console.log(snapshot)
      this.loading = false
      await snapshot.docs.map(doc => {
        this.messages.push(doc.data())
        console.log('data', doc.data())
      });
    }
  },
  created() {
    this.getMessages()
  }
}
</script>

<style scoped>

</style>