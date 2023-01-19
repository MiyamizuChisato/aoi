<script setup>
import DefaultHeaderMenu from './DefaultHeaderMenu.vue';
import DefaultHeaderPrefix from './DefaultHeaderPrefix.vue';
import DefaultHeaderSuffix from './suffix/DefaultHeaderSuffix.vue';
import ReturnTop from '../../components/ReturnTop.vue';
</script>
<template>
    <header class='animate__animated animate__fadeInDown' shadow='sm' flex-center>
        <default-header-prefix left='24' position='absolute' />
        <default-header-menu />
        <default-header-suffix right='24' position='absolute' />
    </header>
    <return-top />
</template>
<style scoped>
header {
    top: 0;
    z-index: 10;
    height: 54px;
    position: sticky;
    transition: top 555ms;
    background-color: var(--c-header);
    backdrop-filter: saturate(50%) blur(10px);
}
</style>
