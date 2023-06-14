import {
	get
} from '@/service/config.js'
export function login() {
	return new Promise((resolve, reject) => {
		// #ifdef MP-WEIXIN
		uni.login({
			provider: 'weixin', //使用微信登录
			success: function(loginRes) {
				get("/wechat/login", {
					code: loginRes.code
				}).then(res => {
					uni.setStorage({
						key: "login",
						data: JSON.stringify(res.data),
						success() {
							console.log("保存成功")
						}
					})
					resolve(res)

				}).catch(err => {
					reject(err)
				})
			}
		});
		// #endif
		// #ifdef H5 || APP-PLUS
		uni.setStorage({
			key: "login",
			data: JSON.stringify({
				openid: "d0ef3bab-6dbe-429a"
			}),
			success() {
				resolve({
				openid: "d0ef3bab-6dbe-429a"
			})
			}
		})
		// #endif
	})

}