export class job_seeker_project{
    constructor(
        public  title:string,
        public  description:string,
        public role:string
    ){}
}

export class job_seeker_skills{
    constructor(
        public  certificate_name:string,
        public  certificate_issue_date:string,
        public skill_id:number,
        public skil_level:number
    ){}
}

export class job_seeker_experience{
    constructor(
        public  job_title:string,
        public start_date:string,
        public end_date:string,
        public job_description:string,
       public location:any
    ){}
}

export class job_seeker_education{
    constructor(
      
        public start_date:string,
        public end_date:string,
        public marks_percentage:number,
       public course_id:number,
       public specialization_id:number  = null,
       public education_type_id:number  = null
    ){}

    
}

