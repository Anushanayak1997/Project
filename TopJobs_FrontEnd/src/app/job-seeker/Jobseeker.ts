export class job_seeker_project {
    constructor(
        public title: string,
        public description: string,
        public role: string
    ) { }
}

export class job_seeker_skills {
    constructor(
        public certificate_name: string,
        public certificate_issue_date: string,
        public skill_id: number,
        public skil_level: number
    ) { }
}

export class job_seeker_experience {
    constructor(
        public job_title: string,
        public start_date: string,
        public end_date: string,
        public job_description: string,
        public streetaddress: string,
        public city: string,
        public state: string,
        
    ) { }
}

export class job_seeker_education {
    constructor(

        public start_date: string,
        public end_date: string,
        public marks_percentage: number,
        public course_id: number,
        public specialization_id: number = null,
        public education_type_id: number = null
    ) { }


}


export interface seeker_Profile {
    firstName: string,
    lastName: string,
    emailID: string,
    contactNumber: string
}

export interface Education {
    start_date: string,
    end_date: string,
    marks_percentage: string,
}

export interface Certification {
     certificate_name: string,
     certificate_issue_date: string,
}


export interface Experience{
     job_title: string,
     start_date: string,
     end_date: string,
     job_description: string,
     streetaddress: string,
     city: string,
     state: string,
}

export interface Project {
     title: string,
     description: string,
     role: string
}

