import React from 'react'
import {useQuery, gql, useMutation} from "@apollo/client";
import {Mutation} from "@apollo/client/react/components";

/*const CREATE_EMPLOYEE=gql `
    mutation($employeeNo:Float!,$firstName:String!,$lastName:String!,$dob:Date!){
        createArgsEmployee(employeeNo:$employeeNo,firstName:$firstName,lastName:$lastName,dob:$dob){
            firstName
        }
    }`
*/
const CREATE_EMPLOYEE=gql `
    mutation($employeeInput:EmployeeInput!){
        createEmployee(input:$employeeInput){
            firstName

        }
    }`

export default function CreateEmployee(){

    var obj={
        "employeeNo": 4867,
        "firstName": "queen234",
        "lastName": "Kumar",
        "dob": "1980-07-03"
    }
const [createEmployee,{data,error,loading}]=useMutation(CREATE_EMPLOYEE,{
    variables:{
        employeeInput:obj
    }
})
    return (
      <div>
       <button onClick={()=>{createEmployee()}}>
           Add Employee
       </button>
      </div>
    );
}
