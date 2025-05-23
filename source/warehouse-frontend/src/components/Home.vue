
<template>
    <div
        style="
            text-align: center;
            height: 100%;
            padding: 20px 0 0 0;
            margin: 0px;
        "
    >
        <div class="welcome">
            <b>
                <span style="color: #e75c09"> 欢迎使用仓库管理系统</span>

            </b>
        </div>

        <br />
        <br />

        <div style="text-align: center; height: 35vw">
            <img
                :src="require('@/assets/background.jpg')"
                style="height: 100%"
            />
        </div>
    </div>
</template>

<script>
import DateUtils from "./DateUtils";
export default {
    name: "Home",
    components: { DateUtils },
    data() {
        return {
            user: {},
        };
    },
    computed: {},
    methods: {
        init() {
            this.user = JSON.parse(sessionStorage.getItem("CurUser"));
        },
    },
    created() {
        this.init();
    },
};
</script>

<style scoped>
.welcome {
    font-size: 30px;
    color: grey;
}
</style>
