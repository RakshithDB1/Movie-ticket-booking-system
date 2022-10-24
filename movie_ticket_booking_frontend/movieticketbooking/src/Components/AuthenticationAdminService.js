class AuthenticationAdminService{

    adminSuccessfullLogin(userid,password){
        sessionStorage.setItem("authenticatedAdmin",userid);
    }

    isAdminLoggedIn(){
        let admin=sessionStorage.getItem("authenticatedAdmin");
        if(admin==null) return false;
        return true;
    }

    adminLogout(){
        sessionStorage.removeItem("authenticatedAdmin");
    }

}

export default new AuthenticationAdminService();