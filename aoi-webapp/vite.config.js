import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import Unocss from 'unocss/vite';
import unocssConfig from './uno.config.js';

export default defineConfig({
    plugins: [
        vue(),
        Unocss(unocssConfig)
    ]
});
