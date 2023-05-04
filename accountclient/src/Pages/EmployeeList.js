import React from 'react'
import {useQuery,gql} from "@apollo/client";
const GET_EMPLOYEES=gql `
 query{
  employees{
    firstName,
    lastName,
    dob
  }
}
`
export default function EmployeeList(){
    const {error,data,loading}=useQuery(GET_EMPLOYEES);
    console.log({error,data,loading});
   if (loading) return <div>spinner....</div>
   if (error)  return <div>OOPS!!!!!!!!!!</div>
return <div>
    <table>
    <tbody>
    {
        data.employees.map(emp=>{
            return(
                <tr key={emp.employeeNo}>
                    <td>{emp.firstName}</td>
                    <td>{emp.lastName}</td>
                    <td>{emp.dob}</td>
                </tr>
            )
        })
    }
    </tbody>
    </table>
</div>
}
