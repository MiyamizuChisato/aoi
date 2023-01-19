<script setup>
import Toc from './Toc.vue';
import 'bytemd/dist/index.css';
import { useRoute } from 'vue-router';
import { Viewer } from '@bytemd/vue-next';
import 'juejin-markdown-themes/dist/juejin.min.css';
import { fetchBlogContent } from '../../../../api/blog.js';
import { getViewerPlugins } from '../../../../utils/markdown.js';
import { blogContentHook } from '../../../../hooks/blogContentHook.js';

const plugins = getViewerPlugins();
const route = useRoute();
const text = await fetchBlogContent(route.params.id);
const { blogToc, select } = blogContentHook();
</script>
<template>
    <div rounded='md:b-sm' p='x-30px' bg-container>
        <viewer :value='text' :plugins='plugins' />
    </div>
    <div class='blog-toc' data-aos='animate__fadeIn' display='xl:block lt-xl:none' position='fixed' top='80'>
        <toc v-for='(toc,index) in blogToc' :toc='toc' :key='index' :select='select' />
    </div>
</template>
<style scoped>
.markdown-body {
    overflow: hidden !important;
    color: var(--c-regular);
}

:deep(h1) {
    color: var(--c-strong) !important;
    font-weight: 600 !important;
}

:deep(h2) {
    color: var(--c-strong) !important;
    border: none !important;
}

:deep(h3) {
    color: var(--c-strong) !important;
}

:deep(h4) {
    color: var(--c-strong) !important;
}

:deep(h5) {
    color: var(--c-strong) !important;
}

:deep(h6) {
    color: var(--c-strong) !important;
}

:deep(pre code) {
    font-size: 14px;
    color: var(--c-regular);
    background: var(--c-fill) !important;
    border-radius: 6px;
}

:deep(blockquote) {
    background: var(--c-fill) !important;
}

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