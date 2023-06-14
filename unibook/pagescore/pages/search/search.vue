<template>
	<view>
		<view class="search">
					<view class="myinput">
						<input class="uni-input"  v-model:value="value" style="display: block;" auto-blur focus placeholder="输入关键字" />
					</view>
				<view >
					<button @click="handleSearch">搜索</button>
				</view>
		</view>
		<uni-list :border="true">
			<uni-list-item v-for="item in list" :key="item.id" :title="item.title" clickable
				@click="handleItem(item.id)" :note="`${item.introduction.substring(0,35)}`+'...'" :thumb="item.img"
				thumb-size="lg" :rightText="`豆瓣 ${item.score}分`"></uni-list-item>
		</uni-list>
	</view>
</template>

<script>
import {search} from '@/service/score.js'

	export default {
		data() {
			return {
				value:"",
				list:[]
			}
		},
		methods: {
			handleItem(id) {
				console.log("我被点击", id)
				uni.navigateTo({
					url: "/pagescore/pages/bookdetail/bookdetail?id=" + id
				})
			},
			handleSearch(){
				console.log(this.value)
				search(this.value).then(res=>{
					console.log(res.data)
					this.list=res.data
				})
			}
		}
	}
</script>

<style scoped>
.search{
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10rpx 10rpx;
}
.search .myinput{
	background-color: #ffffff;
	padding: 20rpx 0;
	flex-grow: 1;
}
.search button{
	align-content:flex-end;
	margin: 0 20rpx;
}
</style>
