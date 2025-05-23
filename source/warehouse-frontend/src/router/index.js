
import VueRouter from 'vue-router';
import Vue from 'vue'

Vue.use(VueRouter)

const routes = [
    {
        path:'/',
        name:'login',
        component:()=>import('../components/Login')
    },
    {
        path:'/Index',
        name:'index',
        component:()=>import('../components/Index'),
        children:[
            {
                path:'/Home',
                name:'home',
                meta:{
                    title:'首页'
                },
                component:()=>import('../components/Home')
            },
            {
                path:'/Profile',
                name:'profile',
                meta:{
                    title:'个人中心'
                },
                component:()=>import('../components/Profile')
            },
        ]
    }
]

const router = new VueRouter({
    mode:'history',
    routes
})

export function resetRouter() {
    router.matcher = new VueRouter({
        mode:'history',
        routes: []
    }).matcher
}

// 挂载路由导航守卫(防止没有进行验证后直接跳转到了相关页面)
router.beforeEach((to, from, next) => {
    //to 将要访问的路径
    // from 代表从哪个路径跳转而来
    // next是一个函数，表示放行
    // next() 放行  next('/login')强制性跳转到指定路由
    next()
})

// import 'vue-vibe'
// const VueRouterPush = VueRouter.prototype.push
// VueRouter.prototype.push = function push (to) {
//     return VueRouterPush.call(this, to).catch(err => err)
// }
export  default router;
