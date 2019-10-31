export class User{

    constructor(
        public Index:number,
        public Position:string,
        public Vaccancies:string,
        public Status:string,
        public Apllicants:number,
        public Date:Date,
    ){}

     
}

export interface user{
     Index:number,
     Position:string,
     Vaccancies:string,
     Status:string,
     Apllicants:number,
     Date:Date,  
}