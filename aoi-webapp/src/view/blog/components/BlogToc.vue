<script setup>
import Toc from './Toc.vue';
import { tocMarkdown } from '../../../hooks/tocMarkdown.js';
import { provide } from 'vue';

const { blogToc, select, jumpTrigger } = tocMarkdown();

provide('jumpTrigger', jumpTrigger);
</script>
<template>
    <div id='blogToc' class='blog-toc' data-aos='fade' display='xl:block lt-xl:none' position='fixed' top='80'>
        <toc v-for='(toc,index) in blogToc' :toc='toc' :key='index' :select='select' />
    </div>
</template>
<style scoped>
.blog-toc {
    bottom: 0;
    right: 70px;
    font-size: 12px;
    position: fixed;
    user-select: none;
    overflow-y: scroll;
    max-width: 200px;
    padding-right: 20px;
}

.blog-toc::-webkit-scrollbar-thumb {
    background-color: transparent
}

.blog-toc:hover::-webkit-scrollbar-thumb {
    background-color: var(--c-disable);
}

.blog-toc:hover :deep(.toc-text) {
    opacity: 1;
}
</style>