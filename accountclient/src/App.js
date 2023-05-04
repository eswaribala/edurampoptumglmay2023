import logo from './logo.svg';
import './App.css';
import EmployeeList from "./Pages/EmployeeList";
import CreateEmployee from "./Pages/CreateEmployee";
import CreateEmployeeSubscription from "./Pages/CreateEmployeeSubscription";

function App() {

  return (
    <div className="App">
    <CreateEmployee/>
    <EmployeeList/>
    <CreateEmployeeSubscription/>
    </div>
  );
}
export default App;
