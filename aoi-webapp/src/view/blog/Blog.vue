<script setup>
import BlogInfo from './components/BlogInfo.vue';
import BlogContent from './components/content/BlogContent.vue';
import BlogComment from './components/BlogComment.vue';
</script>
<template>
    <div m='md:y-5' overflow='hidden' w='md:720px' margin-center>
        <blog-info />
        <blog-content />
        <blog-comment />
    </div>
</template>


