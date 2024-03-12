const person = {
    name: 'Ranga',
    address: {
        line1 : 'Baker Street',
        city: 'London',
        country: 'UK',
    },
    profiles: ['twitter', 'Linkedin', 'instagram'],
    printProfile: () => {
        person.profiles.map(
            profiles => console.log(profiles)
        )
    }
}

export default function LearningComponent(){
    return(
        <>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.address.city}</div>
            <div>{person.address.country}</div>
            <div>{person.profiles[0]}</div>
            <div>{person.printProfile()}</div>
        </>
    )
}