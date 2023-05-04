import logo from './logo.svg';
import './App.css';
import TransactionList from "./Pages/TransactionList";
import CreateEmployee from "./Pages/CreateEmployee";
import CreateEmployeeSubscription from "./Pages/CreateEmployeeSubscription";

function App() {

  return (
    <div className="App">
    <CreateEmployee/>
    <TransactionList/>
    <CreateEmployeeSubscription/>
    </div>
  );
}
export default App;
