<template>
  <header class="header_area">
    <div class="main_menu">
      <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
          <!-- Brand and toggle get grouped for better mobile display -->
          <a class="navbar-brand logo_h" href=""><img src="../assets/img/logo.svg" alt=""></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                  aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav justify-content-end">
              <li class="nav-item active">
                <a class="nav-link" href="/" @click.prevent="scrollFix('#home')" id="schome">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/" @click.prevent="scrollFix('#about')" id="scabout">About</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/" @click.prevent="scrollFix('#services')" id="scservices">Services</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/" @click.prevent="scrollFix('#portfolio')" id="scportfolio">Portfolio</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/" @click.prevent="scrollFix('#contact')" id="sccontact">Contact</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </header>
</template>

<script>
/* eslint-disable no-undef */

export default {
  name: 'Nav',
  methods: {
    scrollFix: function (hash) {
      setTimeout(() => $('html, body').animate({
        // eslint-disable-next-line no-undef
        scrollTop: $(hash).offset().top
      }, 1000), 1)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
