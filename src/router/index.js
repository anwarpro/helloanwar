import {createRouter, createWebHashHistory} from 'vue-router'
import Home from '../views/Home.vue'
import {firebase} from '@/firebase'

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/admin',
        name: 'Admin',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/Admin.vue'),
        meta: {
            requiresAuth: true
        }
    },
    {
        path: '/login',
        name: 'Login',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach(async (to, from, next) => {
    // eslint-disable-next-line no-undef
    const requiresAuth = to.matched.some(record => record.meta.requiresAuth);

    if (requiresAuth && !await firebase.getCurrentUser()) {
        next('login');
    } else {
        next();
    }

})


export default router
