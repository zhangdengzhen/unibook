import {get} from '@/service/config.js'
export function getbyid(id){
	return get("/book/selectByid",{id})
}
export function search(key){
	return get("/book/searchBytitle",{key})
}