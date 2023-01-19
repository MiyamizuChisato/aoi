import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import Unocss from 'unocss/vite';
import { theme, shortcuts, presets, rules } from './uno.config.js';

export default defineConfig({
    plugins: [
        vue(),
        Unocss({
            theme, shortcuts, presets, rules
        })
    ],
    server: {
        port: 80,
        proxy: {
            '/aoi': {
                changeOrigin: true,
                target: 'http://192.168.1.182:8080'
            }
        }
    }
});
