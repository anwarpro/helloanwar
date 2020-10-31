import {createApp} from 'vue'
import App from './App.vue'

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'

import 'owl.carousel2'
import 'owl.carousel2/dist/assets/owl.carousel.min.css'
import 'owl.carousel2/dist/assets/owl.theme.default.min.css'

import 'isotope-layout/dist/isotope.pkgd.min'
import router from './router'

createApp(App).use(router).mount('#app')
