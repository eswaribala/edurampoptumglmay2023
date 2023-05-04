import React from 'react'
import {useQuery,gql} from "@apollo/client";
const GET_TRANSACTIONS=gql `
    query{
        showTransactions{
            amount
            timeStamp
            account{
                runningTotal
            }
        }
    }
`
export default function TransactionList(){
    const {error,data,loading}=useQuery(GET_TRANSACTIONS);
    console.log({error,data,loading});
   if (loading) return <div>spinner....</div>
   if (error)  return <div>OOPS!!!!!!!!!!</div>
return <div>
    <table border="1">
     <thead>
     <th>
         Amount
     </th>
     <th>
         Time Stamp
     </th>
     <th>
         Running Total
     </th>
     </thead>
    <tbody>
    {
        data.showTransactions.map(transaction=>{
            return(
                <tr key={transaction.amount}>
                    <td>{transaction.amount}</td>
                    <td>{transaction.timeStamp}</td>
                    <td>{transaction.account.runningTotal}</td>
                </tr>
            )
        })
    }
    </tbody>
    </table>
</div>
}
