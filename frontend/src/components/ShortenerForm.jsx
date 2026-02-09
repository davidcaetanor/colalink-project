export default function ShortenerForm() {
  return (
    <form className="flex flex-col items-center gap-4 mt-5">
      <input
        className="p-1 w-3/4 font-semibold text-base text-center rounded-md border-2 border-[#69552e]"
        type="url"
        placeholder="Cola seu Link aqui.."
      />
      <input
        className="p-1.5 w-3/4 m-px cursor-pointer text-base text-white font-semibold text-center rounded-md bg-[#513300] hover:bg-[#7a4d00]"
        type="button"
        value="Encurtar"
      />
    </form>
  );
}
