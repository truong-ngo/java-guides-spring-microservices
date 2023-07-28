import { get } from "../utils/http";
import { EMPLOYEE_ENDPOINT } from "../constant/endpoint";

export const getEmployees = async () => {
    const res = await get(EMPLOYEE_ENDPOINT);
    if (res.status == 200) {
        return res.data
    }
}

export const getEmployee = async (id) => {
    const res = await get(`${EMPLOYEE_ENDPOINT}/${id}`)
    if (res.status == 200) {
        return res.data
    }
}
