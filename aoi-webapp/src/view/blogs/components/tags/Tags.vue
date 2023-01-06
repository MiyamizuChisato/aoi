<script setup>
import AsyncTag from './AsyncTag.vue';
import LoadingTags from './LoadingTags.vue';
</script>
<template>
    <suspense>
        <template #default>
            <async-tag />
        </template>
        <template #fallback>
            <loading-tags />
        </template>
    </suspense>
</template>
