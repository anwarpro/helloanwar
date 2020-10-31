<template>
  <!--================ Start Header Area =================-->
  <Nav></Nav>
  <!--================ End Header Area =================-->

  <router-view></router-view>

  <!--================Footer Area =================-->
  <Footer></Footer>
  <!--================End Footer Area =================-->
</template>

<script>

import Nav from "@/components/Nav";
import Footer from "@/components/Footer";

global.jQuery = require('jquery');
// eslint-disable-next-line no-unused-vars
var $ = global.jQuery;
var jQuery = global.jQuery;
window.$ = jQuery;
window.jQuery = jQuery;

global._ = require('loadsh');
// eslint-disable-next-line no-unused-vars
var _ = global._;
window._ = global._;

export default {
  name: 'App',
  components: {
    Nav,
    Footer
  },
  methods: {

  }
}
</script>

<style>
@import './assets/vendors/linericon/style.css';
@import './assets/css/font-awesome.min.css';

/*@import './assets/css/magnific-popup.css';*/
/*@import './assets/vendors/nice-select/css/nice-select.css';*/

@import './assets/css/style.css';

.feature_item ul {
  text-align: left !important;
}

.subscription_box .subscription textarea, .subscription_box .subscription input {
  min-width: 380px;
  max-width: 380px;
  line-height: 1.5;
  padding: 15px 25px;
  border: 1px solid #ffffff;
  background: transparent;
  font-weight: 400;
  border-radius: 5px;
  color: #ffffff;
  margin-bottom: 10px;
}

.feature_item ul {
  text-align: left !important;
}

.subscription_box .subscription textarea, .subscription_box .subscription input {
  min-width: 380px;
  max-width: 380px;
  line-height: 1.5;
  padding: 15px 25px;
  border: 1px solid #ffffff;
  background: transparent;
  font-weight: 400;
  border-radius: 5px;
  color: #ffffff;
  margin-bottom: 10px;
}

.navbar-light .navbar-toggler {
  border: none !important;
}

body.modal-open {
  overflow: hidden;
}
</style>

