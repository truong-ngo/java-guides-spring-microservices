import React, { useEffect, useState } from 'react';
import { getEmployee } from '../../service/employee-service';

const Employee = (props) => {

    const [employees, setEmployees] = useState({});
    const [isLoading, setLoading] = useState(false);

    useEffect(() => {
        async function get() {
           
            const res = await getEmployee(props.id);
            setEmployees(res)
            
        };
        get(); 
    }, [])

    return <>
        <br/><br/>
        <div className='col-md-6 card offset-md-3'>
            <h3 className='text-center card-header'>View Employee Details</h3>
            <div className='card-body'>
                <div className='row'>
                    <p><strong>Employee First Name:</strong> {employees.employee?.firstName}</p>
                </div>
                <div className='row'>
                    <p><strong>Employee Last Name:</strong> {employees.employee?.lastName}</p>
                </div>
                <div className='row'>
                    <p><strong>Employee Email:</strong> {employees.employee?.lastName}</p>
                </div>
            </div>
            <h3 className='text-center card-header'>View Department Details</h3>
            <div className='card-body'>
                <div className='row'>
                    <p><strong>Department Name:</strong> {employees.department?.name}</p>
                </div>
                <div className='row'>
                    <p><strong>Department Description:</strong> {employees.department?.description}</p>
                </div>
                <div className='row'>
                    <p><strong>Department Code:</strong> {employees.department?.code}</p>
                </div>
            </div>
            <h3 className='text-center card-header'>View Organization Details</h3>
            <div className='card-body'>
                <div className='row'>
                    <p><strong>Organization Name:</strong> {employees.organization?.name}</p>
                </div>
                <div className='row'>
                    <p><strong>Organization Description:</strong> {employees.organization?.description}</p>
                </div>
                <div className='row'>
                    <p><strong>Organization Code:</strong> {employees.organization?.code}</p>
                </div>
            </div>
        </div>
    </>
}

export default Employee;
