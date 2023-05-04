import React, {useEffect} from 'react'
import {useQuery, gql, useMutation, useSubscription} from "@apollo/client";
import {Mutation} from "@apollo/client/react/components";

/*const CREATE_EMPLOYEE=gql `
    mutation($employeeNo:Float!,$firstName:String!,$lastName:String!,$dob:Date!){
        createArgsEmployee(employeeNo:$employeeNo,firstName:$firstName,lastName:$lastName,dob:$dob){
            firstName
        }
    }`
*/

const EMPLOYEES_SUBSCRIPTION = gql`
    subscription{
        employeeAdded{
            firstName
        }
    }
`;

export  default function CreatEmployeeSubscription() {
    const { data, loading ,error} = useSubscription(
        EMPLOYEES_SUBSCRIPTION

    );
    console.log({data,loading,error});


    return <h4>New comment: {!loading && data}</h4>;
}
