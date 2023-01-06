import { createApp } from 'vue';
import App from './App.vue';
import vuetify from './plugin/vuetify.js';
import router from './router/index.js';
import Aos from 'aos';
import { createPinia } from 'pinia';

const pinia = createPinia();
Aos.init({
    offset: 20,
    once: false,
    useClassNames: true,
    initClassName: false,
    animatedClassName: 'animate__animated'
});
createApp(App)
    .use(pinia)
    .use(router)
    .use(vuetify)
    .mount('#app');
