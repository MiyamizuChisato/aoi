import { createRouter, createWebHistory } from 'vue-router';
import Default from '../layout/Default.vue';
import Home from '../view/home/Home.vue';

const routes = [
    {
        path: '/',
        name: 'layout',
        component: Default,
        redirect: '/home',
        children: [
            {
                path: '/home',
                name: 'home',
                component: Home,
                meta: {
                    alive: true
                }
            },
            {
                path: '/blogs',
                name: 'blogs',
                component: () => import('../view/blogs/Blogs.vue'),
                meta: {
                    alive: true
                }
            },
            {
                path: '/messages',
                name: 'messages',
                component: () => import('../view/messages/Messages.vue')
            },
            {
                path: '/friends',
                name: 'friends',
                component: () => import('../view/friends/Friends.vue')
            },
            {
                path: '/blog/:id',
                name: 'blog',
                component: () => import('../view/blog/Blog.vue')
            }
        ]
    },
    {
        name: 'oauth',
        path: '/oauth/:type',
        component: () => import('../view/oauth/Oauth.vue'),
        children: []
    },
    {
        name: 'admin',
        path: '/admin',
        component: () => import('../layout/Admin.vue'),
        children: []
    }
];
const router = createRouter({
    routes,
    history: createWebHistory(),
    scrollBehavior(to, from, savedPosition) {
        if (savedPosition && to.name !== 'blog') {
            return savedPosition;
        } else {
            return { top: 0 };
        }
    }
});
export default router;
