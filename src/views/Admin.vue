<template>
  <section class="about_area section_gap content_section" style="padding-bottom: 0px; padding-top: 120px">
    <div class="container">
      <div class="row justify-content-start" style="margin-bottom: 50px">
        <div class="col-md-3">
          <ul class="list-group">
            <li class="list-group-item" :class="{active: view==='Dashboard'}" @click="switchComponent('Dashboard')">
              Dashboard
            </li>
            <li class="list-group-item" :class="{active: view==='Projects'}" @click="switchComponent('Projects')">
              Projects
            </li>
            <li class="list-group-item" :class="{active: view==='Messages'}" @click="switchComponent('Messages')">
              Messages
            </li>
          </ul>
        </div>
        <div class="col-md-9">
          <component v-bind:is="view"/>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import Dashboard from "@/components/admin/Dashboard";
import Projects from "@/components/admin/Projects";
import Messages from "@/components/admin/Messages";

/* eslint-disable no-undef */

export default {
  name: "Admin",
  data() {
    return {
      view: 'Dashboard'
    }
  },
  components: {
    Dashboard,
    Projects,
    Messages
  },
  methods: {
    switchComponent(name) {
      console.log(name)
      this.view = name
    }
  },
  mounted() {
    window.document.onscroll = () => {
      let nav_offset_top = $('header').height() + 50;

      // eslint-disable-next-line no-undef
      var scroll = $(window).scrollTop();
      if (scroll >= nav_offset_top) {
        // eslint-disable-next-line no-undef
        $('.header_area').addClass('navbar_fixed');
      } else {
        // eslint-disable-next-line no-undef
        $('.header_area').removeClass('navbar_fixed');
      }
    }
  }
}
</script>

<style scoped>
ul li {
  margin-bottom: 5px;
}

ul li:hover {
  background: #007bff;
  color: #fff;
  cursor: pointer;
}
</style>