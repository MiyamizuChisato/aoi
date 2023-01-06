<script setup>
import { computed, onMounted, ref } from 'vue';
import { useWindowSize } from '@vueuse/core';

const observer = ref(null);
const { height } = useWindowSize();
const scope = computed(() => {
    return `-54px 0px -${height.value - 254}px 0px`;
});
let ob = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            console.log(1);
        }
    });
}, { threshold: 0.3, rootMargin: scope.value });
const init = () => {
    ob.observe(observer.value);
    window.onresize = () => {
        ob.disconnect();
        ob = new IntersectionObserver(entries => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    console.log(1);
                }
            });
        }, { threshold: 0.3, rootMargin: scope.value });
        ob.observe(observer.value);
    };
};
onMounted(() => {
    init();
});
</script>
<template>
    <div position='fixed' left='0' h='254px' top='0' z='100' bg-success w='100%'>{{ height }}</div>
    <div h='250vh'></div>
    <div ref='observer' w='100px' h='200px' bg-primary>
        <div h='30%' bg-danger>

        </div>
    </div>
    <div h='250vh'></div>
</template>
