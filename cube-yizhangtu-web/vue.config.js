const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {
        target: 'http://101.42.46.104:8889',
        changeOrigin: true,   // 开启代理，在本地创建一个虚拟服务 
        pathRewrite: {
          '^/api': ''
        }
      }
    }
  },
})
