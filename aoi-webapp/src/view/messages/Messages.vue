<script setup>
import Editor from '../../components/Editor.vue';
import { provide, reactive, ref } from 'vue';
import ViewerWrapper from '../../components/ViewerWrapper.vue';

const editor = ref(null);
const message = reactive({
    content: '',
    toUserId: 0,
    parentId: 0
});
const send = () => {
};
provide('editor', editor);
</script>
<template>
    <div m='y-5' w='md:720px' p-x-lt-md margin-center>
        <editor ref='editor' v-model='message.content' :send='send' />
        <viewer-wrapper m='y-5' v-for='i in 12' />
    </div>
</template>
