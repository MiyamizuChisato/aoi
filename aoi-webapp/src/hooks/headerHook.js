import { onMounted, ref } from 'vue';
import { useWindowScroll } from '@vueuse/core';

export const headerControl = () => {
    const show = ref(true);
    onMounted(() => {

        window.addEventListener('scroll', () => {

        });
    });
    return show;
};