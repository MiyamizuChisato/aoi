<script setup>
import AsyncBlogContent from './AsyncBlogContent.vue';
import LoadingBlogContent from './LoadingBlogContent.vue';
</script>
<template>
    <suspense>
        <template #default>
            <async-blog-content />
        </template>
        <template #fallback>
            <loading-blog-content />
        </template>
    </suspense>
</template>
