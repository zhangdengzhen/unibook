import {get,post} from '@/service/config.js'

export function selectRecommend(curPage,PageSize){
	return get("/recommend/selectbypage",{curPage,PageSize})
}
export function selectByid(id){
	return get("/recommend/selectByid",{id})
}