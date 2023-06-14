import {get} from '@/service/config.js'
export function getreadNode(curPage,PageSize){
	return get("/read/selectbypage",{curPage,PageSize})
}
// 根据id获取读后感
export function getbyid(id){
	return get("/read/selectbyid",{id})
}
