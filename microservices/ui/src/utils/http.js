import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9999"
});

export const get = async (endpoint, params) => {
    const res = await http.get(endpoint, {
        params: params
    })
    return res;
}