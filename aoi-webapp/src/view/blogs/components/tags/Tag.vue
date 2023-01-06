<script setup>
import { ref } from 'vue';
import SvgIcon from '../../../../components/SvgIcon.vue';

defineProps({
    tag: String
});
const icon = ref('');
</script>
<template>
    <v-chip m='1' size='small' select='none' text-strong v-ripple pointer label>
        <template #prepend>
            <svg-icon :icon='icon' />
        </template>
        #{{ tag }}#
        <template #append>
            (134)
        </template>
    </v-chip>
</template>

