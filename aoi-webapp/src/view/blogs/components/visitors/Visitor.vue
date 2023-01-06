<script setup>
defineProps({
    src: String
});

const online = Math.random() > 0.5;

</script>
<template>
    <div hover='bg-hover' p='1' m='1' rounded='1' flex-center flex-col v-ripple pointer>
        <v-avatar :image='src' />
        <div m='y-1' text-strong text-middle>赵Q先生</div>
        <div v-if='online' text-secondary text-small>12小时前来过</div>
        <div v-else text-success text-small>在线</div>
    </div>
</template>
<style scoped>

</style>