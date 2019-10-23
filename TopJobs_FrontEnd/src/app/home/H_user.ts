export class loginUser{
    constructor(
        public emailID:string,
        public password:string,
        public userType:string,
    ){}
}

export class RegiseterUser{
    constructor(
        public firstName:string,
        public lastName: string,
        public emailID:string,
        public password:string,
        public contactNumber:string,
        public userType:string,
        public companyID:string = null,
        public companyName:string = null
        
    ){}
}