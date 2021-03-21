import styled from "styled-components";
import React from 'react'

function AboutMainContent() {
    return (
        <About>
          <h1>Title</h1>
          <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. In, explicabo! Optio doloremque repudiandae laborum quisquam accusamus reici endis autem accusantium. Qui tempora tenetur odio asperiores atque neque! Eaque, necessitatibus ea quisquam optio voluptatum fuga perspiciatis nulla possimus doloribus est quidem amet ab! Autem eveniet explicabo nemo quidem ut assumenda. Dolore corrupti quibusdam numquam voluptatum eos, dicta cumque consequatur suscipit repellendus voluptate illum omnis, maxime eum sit atque veniam aliquam dolor dolorem nisi optio? Dolorem at commodi laboriosam eveniet dolore nam voluptatum dolorum corrupti cumque quia error hic quidem dignissimos optio aspernatur aliquam culpa quis rem ad repellendus minus possimus, quae repudiandae. Vitae totam recusandae eius odit veniam quas ipsum laboriosam quaerat provident fugiat. Quam quibusdam ab, soluta aliquid nemo incidunt assumenda nisi voluptatibus minima iusto dicta aut dolore at magni facere earum accusamus. Expedita alias odio earum totam repellat tempora culpa ratione, iste voluptas sequi eligendi, blanditiis nam illo quis reiciendis.</p>
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Nesciunt, magni adipisci ipsum assumenda amet itaque delectus ullam tempora odit necessitatibus dicta eum, sit mollitia, suscipit accusantium illum rerum debitis officiis consequatur nisi. Iure quod saepe, veritatis sint molestiae voluptatum commodi at voluptate culpa eum mollitia adipisci vitae nulla blanditiis labore earum, ex tempora voluptatem aspernatur praesentium fugit et nisi ea. Voluptatum libero placeat deleniti enim consequuntur officiis. Est, eveniet? Iste, assumenda! Doloremque dolorum, rem fugiat ex, veritatis iste magnam beatae voluptas asperiores, alias fugit commodi dolore saepe! Quod ipsum repudiandae deserunt veritatis blanditiis illo commodi itaque rem eligendi, modi suscipit ratione iusto illum dignissimos eius alias odio molestias voluptas? In beatae sit similique impedit cupiditate quod. Provident minus incidunt repellat nisi officia autem omnis ipsa! Beatae eligendi tempora natus mollitia ut earum vero repellendus incidunt? Voluptatem officiis voluptatibus perferendis provident expedita iusto molestiae sapiente ipsum impedit pariatur quisquam enim, beatae accusamus harum in odio voluptates autem soluta laborum. Quisquam delectus dolores quam accusamus autem dolor explicabo. Commodi tenetur dolorem ad laborum quod sunt quisquam, eius eligendi dignissimos a molestiae magnam velit distinctio ab sit minima cumque. Quo eos architecto vel quasi, iste animi odio cumque quae pariatur nobis qui ad quos ullam at inventore harum rem modi magnam iusto reiciendis consequuntur. Maxime, soluta. Doloremque repellendus asperiores quis. Quaerat adipisci, eveniet, reprehenderit cupiditate eos vel vero aliquam quod, impedit rerum modi.</p>
        </About>
    )
}
const About=styled.div`
    height:100vh;
    display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	justify-content: flex-start;
	align-items: center;
	align-content: center;
    h1{
        line-height:10rem;
    }
    p{
        width:800px;
    }
`;


export default AboutMainContent
