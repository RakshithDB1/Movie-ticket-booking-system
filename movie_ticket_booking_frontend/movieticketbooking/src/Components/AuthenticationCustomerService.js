class AuthenticationCustomerService{

    CustomerSuccessfullLogin(custid,password){
        sessionStorage.setItem("authenticatedCustomer",custid);
    }

    isCustomerLoggedIn(){
        let cust=sessionStorage.getItem("authenticatedCustomer");
        if(cust==null) return false;
        return true;
    }

    customerLogout(){
        sessionStorage.removeItem("authenticatedCustomer");
    }

    isCustomerLoggedIn(){
        let cust=sessionStorage.getItem("authenticatedCustomer")
        if(cust==null) return false;
        return cust;
    }

    

}

export default new AuthenticationCustomerService();