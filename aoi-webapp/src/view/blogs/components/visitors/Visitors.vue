<script setup>

import AsyncVisitor from './AsyncVisitor.vue';
import LoadingVisitors from './LoadingVisitors.vue';
</script>
<template>
    <suspense>
        <template #default>
            <async-visitor />
        </template>
        <template #fallback>
            <loading-visitors />
        </template>
    </suspense>
</template>