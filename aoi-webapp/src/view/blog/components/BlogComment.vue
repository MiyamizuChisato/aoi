<script setup>
import Editor from '../../../components/Editor.vue';
import Typography from '../../../components/Typography.vue';
import MessageList from '../../messages/components/MessageList.vue';
</script>
<template>
    <typography color='primary'>
        <h3>评论</h3>
    </typography>
    <editor />
    <message-list />
</template>
