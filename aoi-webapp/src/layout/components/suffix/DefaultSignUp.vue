<script setup>
import { useAppStore } from '../../../store/appStore.js';

defineProps({
    toggle: Function
});
const appStore = useAppStore();

</script>
<template>
    <div class='sign-up' p='5' bg-container>
        <v-btn @click='appStore.toggleSignDialog' color='transparent' variant='flat' icon>
            <i text='10' i-heroicons-solid-arrow-left-circle text-info />
        </v-btn>
        <div text='24px' m='y-2' font='600' flex-between-x>
            <div text-strong>欢迎加入</div>
            <v-btn @click='toggle' variant='plain'>
                <span text-danger>登录</span>
            </v-btn>
        </div>
        <div m='b-4' text='18px' font='600' text-holder>
            请填写以下信息进行注册
        </div>
        <v-form text-regular>
            <div m='y-1'>
                <v-text-field label='邮箱' prepend-icon='i-material-symbols-alternate-email'>
                    <template #append-inner>
                        <v-btn size='small' bg-success flat>
                            <span text-light>验证</span>
                        </v-btn>
                    </template>
                </v-text-field>
            </div>
            <div m='y-1'>
                <v-text-field label='验证码' prepend-icon='i-material-symbols-check-box' />
            </div>
            <div m='y-1'>
                <v-text-field label='昵称' prepend-icon='i-fluent-rename-28-filled' />
            </div>
            <div m='y-1'>
                <v-text-field label='密码' type='password' prepend-icon='i-material-symbols-lock' />
            </div>
            <div m='y-1'>
                <v-text-field label='主页' placeholder='如果你有自己的网站，欢迎告诉我'
                              prepend-icon='i-zondicons-network' />
            </div>
            <div m='y-1'>
                <v-file-input label='头像' prepend-icon='i-material-symbols-image-rounded'>
                    <template #append-inner>
                        <div w='40px' rounded='full' overflow='hidden'>
                            <v-img src='' />
                        </div>
                    </template>
                </v-file-input>
            </div>
            <div m='y-1'>
                <v-btn size='large' bg-primary block rounded flat>
                    <span text='18px' m='x-2' text-light>继续</span>
                    <i i-heroicons-solid-arrow-right-circle text-light />
                </v-btn>
            </div>
        </v-form>
    </div>
</template>
<style scoped>
@media screen and (min-width: 640px) {
    .sign-up {
        width: 500px;
        margin: auto;
        border-radius: 8px;
    }
}

@media screen and (max-width: 640px) {
    .sign-up {
        height: 100vh;
    }
}

.sign-up {
    overflow-y: scroll;
}

.sign-up::-webkit-scrollbar {
    display: none;
}

:deep(.v-input__append) {
    padding: 0;
    align-items: center;
}

:deep(.v-field__append-inner) {
    padding: 0;
    align-items: center;
}
</style>
