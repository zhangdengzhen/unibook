const baseurl="https://unibook.dengzhenzhang.top"

export function get(url,param){
		return new Promise((resolve,reject)=>{
			uni.showLoading({
				title: '加载中...'
			});
			uni.request({
			    url: baseurl+url, //仅为示例，并非真实接口地址。
				method:"GET",
			    data: param,
			    header: {
			        'custom-header': 'hello' //自定义请求头信息
			    },
			    success: (res) => {
					uni.hideLoading();
			        resolve(res)
			    },
				fail:(res)=> {
					uni.hideLoading();
					reject(res)
				}
			})
		})
	}
export function post(url,param){
		return new Promise((resolve,reject)=>{
			uni.request({
			    url: baseurl+url, //仅为示例，并非真实接口地址。
				method:"POST",
			    data: param,
			    header: {
			        'custom-header': 'hello' //自定义请求头信息
			    },
			    success: (res) => {
			        resolve(res)
			    },
				fail:(res)=> {
					reject(res)
				}
			})
		})
	}
