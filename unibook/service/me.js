export function getlogin(){
	return new Promise((resolve,reject)=>{
		uni.getStorage({
			key: 'login',
			success: function (res) {
				resolve(res.data)
			},
			fail() {
				reject(JSON.stringify({openid:"xxxxxxx"}))
				
			}
		});
	}) 
}