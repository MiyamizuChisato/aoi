<script setup>
import { computed, inject, ref } from 'vue';

const props = defineProps({
    toc: Object,
    select: Number
});
const jumpTrigger = inject('jumpTrigger');
const navigate = (index) => {
    jumpTrigger(index);
};
const tocRef = ref(null);
const scope = [props.toc.index, props.toc.children.length + props.toc.index];
const active = computed(() => {
    if (props.select >= scope[0] && props.select <= scope[1]) {
        if (tocRef.value) {
            tocRef.value.querySelectorAll('.toc-item').forEach(item => {
                if (props.select.toString() === item.getAttribute('data-index')) {
                }
            });
        }
        return true;
    }
    return false;
});
</script>
<template>
    <div class='toc' ref='tocRef' text-disable>
        <div :class='active?"active":""' class='toc-item toc-sup'
             @click='navigate(toc.index)' :data-index='toc.index'>
            <div w='16px' class='toc-icon'></div>
            <div p='l-10px' class='toc-text' font='600' line-1>{{ toc.text }}</div>
        </div>
        <div @click='navigate(subToc.index)' :data-index='subToc.index' class='toc-item toc-sub' :key='index'
             v-for='(subToc,index) in toc.children' :class='subToc.index === select?"active":""'>
            <div w='10px' class='toc-icon'></div>
            <div p='l-18px' class='toc-text'>{{ subToc.text }}</div>
        </div>
    </div>
</template>
<style scoped>
.toc-item {
    display: flex;
    cursor: pointer;
    min-width: 150px;
    align-items: center;
    margin-bottom: 10px;
}

.toc-item:hover .toc-icon {
    background-color: var(--c-regular);
}

.toc-item:hover .toc-text {
    color: var(--c-regular);
}

.toc-icon {
    height: 4px;
    border-radius: 100px;
    background-color: var(--c-disable);
}

.toc-text {
    opacity: 0;
    transition: opacity 200ms ease-out;
}

.active .toc-icon {
    background-color: var(--c-secondary);
}

.active .toc-text {
    opacity: 1;
    color: var(--c-secondary);
}
</style>