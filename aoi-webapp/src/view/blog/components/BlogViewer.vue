<script setup>
import 'bytemd/dist/index.css';
import 'juejin-markdown-themes/dist/juejin.min.css';
import gfm from '@bytemd/plugin-gfm';
import gemoji from '@bytemd/plugin-gemoji';
import frontmatter from '@bytemd/plugin-frontmatter';
import highlight from '@bytemd/plugin-highlight';
import mediumZoom from '@bytemd/plugin-medium-zoom';
import modifyHrefTarget from '../../../plugin/bytemdPluginLink.js';
import imageCenter from '../../../plugin/bytemdPluginImageCenter.js';
import { Viewer } from '@bytemd/vue-next';
import { onUnmounted } from 'vue';
import { aosMarkdown } from '../../../hooks/aosMarkdown.js';
import { styleToggle } from '../../../utils/codeStyle.js';
import BlogToc from './BlogToc.vue';

defineProps({
    md: String
});
const plugins = [
    gfm(),
    gemoji(),
    highlight(),
    mediumZoom(),
    frontmatter(),
    imageCenter(),
    modifyHrefTarget()
];
// 代码高亮主题切换监视器
const stop = styleToggle();
// 滚轮动画初始化器
aosMarkdown();
// 移除代码高亮的监视器
onUnmounted(stop);

</script>
<template>
    <div rounded='md:b-1' shadow='md' p='x-30px' bg-container>
        <viewer :value='md' :plugins='plugins' />
    </div>
    <blog-toc />
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
</style>